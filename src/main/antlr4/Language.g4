grammar Language;

identifier
	: Identifier
	| 'INTEGER'
	| 'DECIMAL'
	;


compileUnit
    :    statements EOF
    ;

statements
	: statement (EndOfLine statement)*
	;

statement
	: declaration
	| assignment
	| ifElseStatement
	| expr
	;

ifElseStatement
    : ifStat = ifStatement elseIfStat = elseIfStatement*  elseStat = elseStatement?
    ;

ifStatement
	: IF LPARA expression=expr RPARA LBRAC body=statements RBRAC
	;

elseIfStatement
	: ELSE IF LPARA expression=expr RPARA LBRAC body=statements RBRAC
	;

elseStatement
	: ELSE LBRAC body=statements RBRAC
	;

assignment
	: variable=VAR op=AssignOP right=expr
	;

declaration
	: type=(INTERGER|DECIMAL) name=VAR
	;

expr
    :   LPARA expr RPARA                                                                                                # parensExpr
    |   op=(PLUS|MINUS) expr                                                                                            # unaryExpr
	|	left=expr op=POWER right=expr                                                                                   # infixExpr
    |   left=expr op=(MULT|DIV) right=expr                                                                              # infixExpr
	|   left=expr op=(PLUS|MINUS) right=expr                                                                            # infixExpr
    |   func=ID LPARA expr RPARA                                                                                        # funcExpr
	|   value=(NUM|VAR)                                                                                                 # valueExpr
	|   NOT expr																										# notExpr
	|   left=expr op=(EQUALS|NEGATIVEEQUALS|GREATERTHAN|LESSTHAN|GREATERTHANEQUALS|LESSTHANEQUALS|OR|AND) right=expr	# booleanExpr
	;

// Control operations
IF      : 'if';
ELSE    : 'else';
FOR     : 'for';
WHILE   : 'while';
LBRAC   : '{';
RBRAC   : '}';

// Binary operations
PLUS    : '+' ;
MINUS   : '-' ;
MULT    : '*' ;
DIV     : '/' ;
POWER   : '^' ;
LPARA   : '(' ;
RPARA   : ')' ;

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

// Keywords
INTERGER : 'INTEGER';
DECIMAL  : 'DECIMAL';

// Misc
EndOfLine : ';';
WS        : [ \t\r\n] -> channel(HIDDEN);

