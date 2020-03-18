package com.test.json;

import com.test.syntax.JsonLexer;
import com.test.syntax.JsonParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.PredictionMode;
import org.antlr.v4.runtime.misc.ParseCancellationException;

import java.util.function.Function;

/**
 * @author machunxiao create at 2020-03-18
 */
public class JsonUtils {
    public static Json parse(String json) {
        try {
            CharStream cis = CharStreams.fromString(json);
            JsonLexer lexer = new JsonLexer(cis);
            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
            JsonParser parser = new JsonParser(tokenStream);

            parser.setErrorHandler(new DefaultErrorStrategy() {
                @Override
                public Token recoverInline(Parser recognizer) {
                    if (nextTokensContext == null) {
                        throw new InputMismatchException(recognizer);
                    } else {
                        throw new InputMismatchException(recognizer, nextTokensState, nextTokensContext);
                    }
                }
            });

            boolean isArray = json.charAt(0) == '[';

            ParserRuleContext tree;
            Function<JsonParser, ParserRuleContext> func;
            if (isArray) {
                func = JsonParser::jsonArray;
            } else {
                func = JsonParser::jsonObject;
            }
            try {
                parser.getInterpreter().setPredictionMode(PredictionMode.SLL);
                tree = func.apply(parser);
            } catch (ParseCancellationException ex) {
                tokenStream.seek(0);
                parser.reset();

                parser.getInterpreter().setPredictionMode(PredictionMode.LL);
                tree = func.apply(parser);
            }

            Object res = new JsonVisitor().visit(tree);

            return (Json) res;
        } catch (StackOverflowError e) {
            throw new RuntimeException(json + " is too large (stack overflow while parsing)");
        }
    }
}
