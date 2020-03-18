grammar Json;

jsonObject
    : LBRACE pair (COMMA pair)* RBRACE ;
jsonArray
    : LSQR value (COMMA value)* RSQR ;
pair
    : name=stringValue COLON value ;

value
    : jsonObject
    | jsonArray
    | stringValue
    | numberValue
    | booleanValue
    | nullValue
    ;
booleanValue
    : TRUE
    | FALSE
    ;
stringValue
    : STRING
    ;
numberValue
    : NUMBER
    ;
nullValue
    : NULL
    ;
/*
 * ==============================================
 * ==============================================
 * Lexer token deinifitions are defined in this section.
 * ==============================================
 * ==============================================
 */
STRING : '"' STRING_CONTENT '"' ;
TRUE : 'true' ;
FALSE : 'false' ;
NULL : 'null' ;
NUMBER : NUM (EXPONENT)? ;
EXPONENT : ([Ee] ([-+])? ([0-9])+) ;
COLON : ':' ;
COMMA : ',' ;
LBRACE : '{' ;
RBRACE : '}' ;
LSQR : '[' ;
RSQR : ']' ;
NUM :
    (([-+])? ([0-9])+ | ([-+])? ([0-9])* '.' ([0-9])+) ;

fragment STRING_CONTENT
    : (~[\n\r\f\\"] | '\\' NL | ESCAPE)* ;
fragment HEX
    : ([0-9a-fA-F]) ;
fragment UNICODE
    : 'u' HEX (HEX (HEX (HEX)?)?)? ;
fragment ESCAPE
    : UNICODE | '\\\\' ~[\r\n\f0-9a-f] ;

WS : [ \t]+ -> skip ;
NL : ([\n\r\f])+ -> skip ;