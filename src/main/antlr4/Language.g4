grammar Language;

compileUnit
    : statements
    ;

statements
	: (statement ';')*
	;

statement
	: functionStatement
	| functionReturnStatement
	| declaration
	| assignment
	| ifElseStatement
	| whileStatement
	| expr
	;

functionStatement
    : type=('int'|'float') name=VAR '(' params=functionParam* ')' '{' body=statements '}'
    ;

functionReturnStatement
    : 'return' expression=expr
    ;

functionParam
    : param=declaration | ',' param=declaration
    ;

whileStatement
    : 'while' '(' expression=expr ')' '{' body=statements '}'
    ;

ifElseStatement
    : ifStat = ifStatement elseIfStat = elseIfStatement*  elseStat = elseStatement?
    ;

ifStatement
	: 'if' '(' expression=expr ')' '{' body=statements '}'
	;

elseIfStatement
	: 'else' 'if' '(' expression=expr ')' '{' body=statements '}'
	;

elseStatement
	: 'else' '{' body=statements '}'
	;

assignment
	: variable=VAR op=AssignOP right=expr
	;

declaration
	: type=('int'|'float') name=VAR
	;


expr
    :   '(' expr ')'                                                                                                    # parensExpr
    |   op=(PLUS|MINUS) expr                                                                                            # unaryExpr
	|	left=expr op=POWER right=expr                                                                                   # infixExpr
    |   left=expr op=(MULT|DIV) right=expr                                                                              # infixExpr
	|   left=expr op=(PLUS|MINUS) right=expr                                                                            # infixExpr
	|   value=(NUM|VAR)                                                                                                 # valueExpr
	|   NOT expr																										# notExpr
	|   left=expr op=(EQUALS|NEGATIVEEQUALS|GREATERTHAN|LESSTHAN|GREATERTHANEQUALS|LESSTHANEQUALS|OR|AND) right=expr	# booleanExpr
	|   name=VAR '(' params=functionCallParam* ')'                                                                      # functionCallExpr
	;

functionCallParam
    : (expr | ',' expr)
    ;

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

// Assignment operation
AssignOP : '=' ;

// Alpha/Num
VAR     : ('a'..'z')+ ;
NUM     : [0-9]+ ('.' [0-9]+)? ([eE] [+-]? [0-9]+)?;

// Misc
EndOfLine : ';';
WS        : [ \t\r\n] -> channel(HIDDEN);

