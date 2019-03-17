lexer grammar LanguageLexerRules;

// Binary operations
PLUS              : '+' ;
MINUS             : '-' ;
MULT              : '*' ;
DIV               : '/' ;
POWER             : '^' ;
MODULO            : '%' ;

// Binary assignment operations
ASSIGNPLUS         : '+=' ;
ASSIGNMINUS        : '-=' ;
ASSIGNMULT         : '*=' ;
ASSIGNDIV          : '/=' ;
ASSIGNPOWER        : '^=' ;
ASSIGNMODULO       : '%=' ;

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

// Data types
INT               : 'int';
FLOAT             : 'float';
BOOL              : 'bool';
VOID              : 'void';

// Keywords
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
VAR               : ('a'..'z'|'A'..'Z'|'_')+ ;
NUM               : [0-9]+ ('.' [0-9]+)? ([eE] [+-]? [0-9]+)?;

// Misc
EndOfLine         : ';';
WS                : [ \t\r\n] -> channel(HIDDEN);

