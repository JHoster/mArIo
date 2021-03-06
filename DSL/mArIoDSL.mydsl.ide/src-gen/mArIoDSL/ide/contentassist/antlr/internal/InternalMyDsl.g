/*
 * generated by Xtext 2.24.0
 */
grammar InternalMyDsl;

options {
	superClass=AbstractInternalContentAssistParser;
}

@lexer::header {
package mArIoDSL.ide.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer;
}

@parser::header {
package mArIoDSL.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import mArIoDSL.services.MyDslGrammarAccess;

}
@parser::members {
	private MyDslGrammarAccess grammarAccess;

	public void setGrammarAccess(MyDslGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}

	@Override
	protected Grammar getGrammar() {
		return grammarAccess.getGrammar();
	}

	@Override
	protected String getValueForTokenName(String tokenName) {
		return tokenName;
	}
}

// Entry rule entryRuleModel
entryRuleModel
:
{ before(grammarAccess.getModelRule()); }
	 ruleModel
{ after(grammarAccess.getModelRule()); } 
	 EOF 
;

// Rule Model
ruleModel 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getModelAccess().getItemAssignment()); }
		(rule__Model__ItemAssignment)*
		{ after(grammarAccess.getModelAccess().getItemAssignment()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleItem
entryRuleItem
:
{ before(grammarAccess.getItemRule()); }
	 ruleItem
{ after(grammarAccess.getItemRule()); } 
	 EOF 
;

// Rule Item
ruleItem 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getItemAccess().getGroup()); }
		(rule__Item__Group__0)
		{ after(grammarAccess.getItemAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Item__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Item__Group__0__Impl
	rule__Item__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Item__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getItemAccess().getItemKeyword_0()); }
	'Item'
	{ after(grammarAccess.getItemAccess().getItemKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Item__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Item__Group__1__Impl
	rule__Item__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Item__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getItemAccess().getItemIDAssignment_1()); }
	(rule__Item__ItemIDAssignment_1)
	{ after(grammarAccess.getItemAccess().getItemIDAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Item__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Item__Group__2__Impl
	rule__Item__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Item__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getItemAccess().getItemNameAssignment_2()); }
	(rule__Item__ItemNameAssignment_2)
	{ after(grammarAccess.getItemAccess().getItemNameAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Item__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Item__Group__3__Impl
	rule__Item__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__Item__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getItemAccess().getDescriptionAssignment_3()); }
	(rule__Item__DescriptionAssignment_3)?
	{ after(grammarAccess.getItemAccess().getDescriptionAssignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Item__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Item__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Item__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getItemAccess().getItemWeightAssignment_4()); }
	(rule__Item__ItemWeightAssignment_4)
	{ after(grammarAccess.getItemAccess().getItemWeightAssignment_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Model__ItemAssignment
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getModelAccess().getItemItemParserRuleCall_0()); }
		ruleItem
		{ after(grammarAccess.getModelAccess().getItemItemParserRuleCall_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Item__ItemIDAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getItemAccess().getItemIDIDTerminalRuleCall_1_0()); }
		RULE_ID
		{ after(grammarAccess.getItemAccess().getItemIDIDTerminalRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Item__ItemNameAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getItemAccess().getItemNameSTRINGTerminalRuleCall_2_0()); }
		RULE_STRING
		{ after(grammarAccess.getItemAccess().getItemNameSTRINGTerminalRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Item__DescriptionAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getItemAccess().getDescriptionSTRINGTerminalRuleCall_3_0()); }
		RULE_STRING
		{ after(grammarAccess.getItemAccess().getDescriptionSTRINGTerminalRuleCall_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Item__ItemWeightAssignment_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getItemAccess().getItemWeightINTTerminalRuleCall_4_0()); }
		RULE_INT
		{ after(grammarAccess.getItemAccess().getItemWeightINTTerminalRuleCall_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;
