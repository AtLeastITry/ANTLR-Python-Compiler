grammar Language;

compileUnit
    :   expr (EndOfLine expr)* EOF
    ;

identifier
	: Identifier
	| 'as'
	| 'VARIABLE'
	| 'INTEGER'
	| 'DECIMAL'
	
  ;

expr
    :   LPARA expr RPARA                      # parensExpr
    |   op=(PLUS|MINUS) expr                  # unaryExpr
	|	left=expr op=POWER right=expr    # infixExpr
    |   left=expr op=(MULT|DIV) right=expr    # infixExpr
	|   left=expr op=(PLUS|MINUS) right=expr    # infixExpr
	|   variable=VAR op=AssignOP right=expr   # assignmentExpr 
    |   func=ID LPARA expr RPARA              # funcExpr             
	|	VARIABLEKEYWORD name=VAR 'as' type=(INTERGER|DECIMAL)			  # variableDeclarationExpr
	|   value=(NUM|VAR)                       # valueExpr
	;
NUM :   [0-9]+ ('.' [0-9]+)? ([eE] [+-]? [0-9]+)?;
PLUS    : '+' ;
MINUS   : '-' ;
MULT    : '*' ;
DIV     : '/' ;
POWER     : '^' ;
LPARA   : '(' ;
RPARA   : ')' ;
AssignOP : ':=' ; 
EndOfLine: ';';
VAR     : ('a'..'z')+ ;
INTERGER: 'INTEGER';
DECIMAL: 'DECIMAL';
VARIABLEKEYWORD : 'VARIABLE';
WS  :   [ \t\r\n] -> channel(HIDDEN);

