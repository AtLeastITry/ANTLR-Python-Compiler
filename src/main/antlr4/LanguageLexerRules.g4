lexer grammar LanguageLexerRules;

// Binary operations
PLUS    : '+' ;
MINUS   : '-' ;
MULT    : '*' ;
DIV     : '/' ;
POWER   : '^' ;

// Boolean operations
EQUALS			  : '==';
NEGATIVEEQUALS    : '!=';
NOT               : '!';
GREATERTHAN       : '>';
LESSTHAN          : '<';
GREATERTHANEQUALS : '>=';
LESSTHANEQUALS    : '<=';
OR                : '||';
AND               : '&&';

//keywords
INT : 'int';
FLOAt: 'float';
ELSE: 'else';
IF: 'if';
WHILE: 'while';
RETURN: 'return';
LPARA: '(';
RPARA: ')';
LBRAC: '{';
RBRAC: '}';
SEMICOLON: ';';
COMMA: ',';

// Assignment operation
AssignOP : '=' ;

// Alpha/Num
VAR     : ('a'..'z')+ ;
NUM     : [0-9]+ ('.' [0-9]+)? ([eE] [+-]? [0-9]+)?;

// Misc
EndOfLine : ';';
WS        : [ \t\r\n] -> channel(HIDDEN);

