lexer grammar LanguageLexerRules;

// Binary operations
PLUS              : '+' ;
MINUS             : '-' ;
MULT              : '*' ;
DIV               : '/' ;
POWER             : '^' ;

// Boolean operations
EQUALS            : '==';
NEGATIVEEQUALS    : '!=';
NOT               : '!';
GREATERTHAN       : '>';
LESSTHAN          : '<';
GREATERTHANEQUALS : '>=';
LESSTHANEQUALS    : '<=';
OR                : '||';
AND               : '&&';

// Keywords
INT               : 'int';
FLOAT             : 'float';
ELSE              : 'else';
IF                : 'if';
WHILE             : 'while';
RETURN            : 'return';

// Flow Controls
LPARA             : '(';
RPARA             : ')';
LBRAC             : '{';
RBRAC             : '}';
COMMA             : ',';

// Assignment operation
AssignOP          : '=' ;

// Alpha/Num
VAR               : ('a'..'z')+ ;
NUM               : [0-9]+ ('.' [0-9]+)? ([eE] [+-]? [0-9]+)?;

// Misc
EndOfLine         : ';';
WS                : [ \t\r\n] -> channel(HIDDEN);

