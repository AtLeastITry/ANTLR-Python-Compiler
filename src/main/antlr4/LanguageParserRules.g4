parser grammar LanguageParserRules;

statements
	: (statement EndOfLine)*
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
    : type=FLOAT name=VAR LPARA params=functionParam* RPARA LBRAC body=statements RBRAC
    | type=INT name=VAR LPARA params=functionParam* RPARA LBRAC body=statements RBRAC
    | type=BOOL name=VAR LPARA params=functionParam* RPARA LBRAC body=statements RBRAC
    | type=VOID name=VAR LPARA params=functionParam* RPARA LBRAC body=statements RBRAC
    ;

functionReturnStatement
    : RETURN expression=expr
    ;

functionParam
    : param=declaration | COMMA param=declaration
    ;

whileStatement
    : WHILE LPARA expression=expr RPARA LBRAC body=statements RBRAC
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
	: variable=VAR op=(AssignOP|ASSIGNPLUS|ASSIGNMINUS|ASSIGNMULT|ASSIGNDIV|ASSIGNPOWER|ASSIGNMODULO) right=expr
	;

binaryAssignment
	: variable=VAR right=expr
	;

declaration
	: type=FLOAT name=VAR
	| type=INT name=VAR
	| type=BOOL name=VAR
	;


expr
    :   LPARA expr RPARA                                                                                                    # parensExpr
    |   op=(PLUS|MINUS) expr                                                                                            # unaryExpr
	|	left=expr op=POWER right=expr                                                                                   # infixExpr
    |   left=expr op=(MULT|DIV|MODULO) right=expr                                                                              # infixExpr
	|   left=expr op=(PLUS|MINUS) right=expr                                                                            # infixExpr
	|   value=(NUM|VAR)                                                                                                 # valueExpr
	|   NOT expr																										# notExpr
	|   left=expr op=(EQUALS|NEGATIVEEQUALS|GREATERTHAN|LESSTHAN|GREATERTHANEQUALS|LESSTHANEQUALS|OR|AND) right=expr	# booleanExpr
	|   name=VAR LPARA params=functionCallParam* RPARA                                                                     # functionCallExpr
	;

functionCallParam
    : (expr | COMMA expr)
    ;