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



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMyDslParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Item'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_STRING=5;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_INT=6;
    public static final int T__11=11;
    public static final int RULE_ML_COMMENT=7;
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalMyDslParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalMyDslParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalMyDslParser.tokenNames; }
    public String getGrammarFileName() { return "InternalMyDsl.g"; }


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



    // $ANTLR start "entryRuleModel"
    // InternalMyDsl.g:53:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // InternalMyDsl.g:54:1: ( ruleModel EOF )
            // InternalMyDsl.g:55:1: ruleModel EOF
            {
             before(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_1);
            ruleModel();

            state._fsp--;

             after(grammarAccess.getModelRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalMyDsl.g:62:1: ruleModel : ( ( rule__Model__ItemAssignment )* ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:66:2: ( ( ( rule__Model__ItemAssignment )* ) )
            // InternalMyDsl.g:67:2: ( ( rule__Model__ItemAssignment )* )
            {
            // InternalMyDsl.g:67:2: ( ( rule__Model__ItemAssignment )* )
            // InternalMyDsl.g:68:3: ( rule__Model__ItemAssignment )*
            {
             before(grammarAccess.getModelAccess().getItemAssignment()); 
            // InternalMyDsl.g:69:3: ( rule__Model__ItemAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalMyDsl.g:69:4: rule__Model__ItemAssignment
            	    {
            	    pushFollow(FOLLOW_3);
            	    rule__Model__ItemAssignment();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getItemAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleItem"
    // InternalMyDsl.g:78:1: entryRuleItem : ruleItem EOF ;
    public final void entryRuleItem() throws RecognitionException {
        try {
            // InternalMyDsl.g:79:1: ( ruleItem EOF )
            // InternalMyDsl.g:80:1: ruleItem EOF
            {
             before(grammarAccess.getItemRule()); 
            pushFollow(FOLLOW_1);
            ruleItem();

            state._fsp--;

             after(grammarAccess.getItemRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleItem"


    // $ANTLR start "ruleItem"
    // InternalMyDsl.g:87:1: ruleItem : ( ( rule__Item__Group__0 ) ) ;
    public final void ruleItem() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:91:2: ( ( ( rule__Item__Group__0 ) ) )
            // InternalMyDsl.g:92:2: ( ( rule__Item__Group__0 ) )
            {
            // InternalMyDsl.g:92:2: ( ( rule__Item__Group__0 ) )
            // InternalMyDsl.g:93:3: ( rule__Item__Group__0 )
            {
             before(grammarAccess.getItemAccess().getGroup()); 
            // InternalMyDsl.g:94:3: ( rule__Item__Group__0 )
            // InternalMyDsl.g:94:4: rule__Item__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Item__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getItemAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleItem"


    // $ANTLR start "rule__Item__Group__0"
    // InternalMyDsl.g:102:1: rule__Item__Group__0 : rule__Item__Group__0__Impl rule__Item__Group__1 ;
    public final void rule__Item__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:106:1: ( rule__Item__Group__0__Impl rule__Item__Group__1 )
            // InternalMyDsl.g:107:2: rule__Item__Group__0__Impl rule__Item__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__Item__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Item__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__Group__0"


    // $ANTLR start "rule__Item__Group__0__Impl"
    // InternalMyDsl.g:114:1: rule__Item__Group__0__Impl : ( 'Item' ) ;
    public final void rule__Item__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:118:1: ( ( 'Item' ) )
            // InternalMyDsl.g:119:1: ( 'Item' )
            {
            // InternalMyDsl.g:119:1: ( 'Item' )
            // InternalMyDsl.g:120:2: 'Item'
            {
             before(grammarAccess.getItemAccess().getItemKeyword_0()); 
            match(input,11,FOLLOW_2); 
             after(grammarAccess.getItemAccess().getItemKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__Group__0__Impl"


    // $ANTLR start "rule__Item__Group__1"
    // InternalMyDsl.g:129:1: rule__Item__Group__1 : rule__Item__Group__1__Impl rule__Item__Group__2 ;
    public final void rule__Item__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:133:1: ( rule__Item__Group__1__Impl rule__Item__Group__2 )
            // InternalMyDsl.g:134:2: rule__Item__Group__1__Impl rule__Item__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__Item__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Item__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__Group__1"


    // $ANTLR start "rule__Item__Group__1__Impl"
    // InternalMyDsl.g:141:1: rule__Item__Group__1__Impl : ( ( rule__Item__ItemIDAssignment_1 ) ) ;
    public final void rule__Item__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:145:1: ( ( ( rule__Item__ItemIDAssignment_1 ) ) )
            // InternalMyDsl.g:146:1: ( ( rule__Item__ItemIDAssignment_1 ) )
            {
            // InternalMyDsl.g:146:1: ( ( rule__Item__ItemIDAssignment_1 ) )
            // InternalMyDsl.g:147:2: ( rule__Item__ItemIDAssignment_1 )
            {
             before(grammarAccess.getItemAccess().getItemIDAssignment_1()); 
            // InternalMyDsl.g:148:2: ( rule__Item__ItemIDAssignment_1 )
            // InternalMyDsl.g:148:3: rule__Item__ItemIDAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Item__ItemIDAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getItemAccess().getItemIDAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__Group__1__Impl"


    // $ANTLR start "rule__Item__Group__2"
    // InternalMyDsl.g:156:1: rule__Item__Group__2 : rule__Item__Group__2__Impl rule__Item__Group__3 ;
    public final void rule__Item__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:160:1: ( rule__Item__Group__2__Impl rule__Item__Group__3 )
            // InternalMyDsl.g:161:2: rule__Item__Group__2__Impl rule__Item__Group__3
            {
            pushFollow(FOLLOW_6);
            rule__Item__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Item__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__Group__2"


    // $ANTLR start "rule__Item__Group__2__Impl"
    // InternalMyDsl.g:168:1: rule__Item__Group__2__Impl : ( ( rule__Item__ItemNameAssignment_2 ) ) ;
    public final void rule__Item__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:172:1: ( ( ( rule__Item__ItemNameAssignment_2 ) ) )
            // InternalMyDsl.g:173:1: ( ( rule__Item__ItemNameAssignment_2 ) )
            {
            // InternalMyDsl.g:173:1: ( ( rule__Item__ItemNameAssignment_2 ) )
            // InternalMyDsl.g:174:2: ( rule__Item__ItemNameAssignment_2 )
            {
             before(grammarAccess.getItemAccess().getItemNameAssignment_2()); 
            // InternalMyDsl.g:175:2: ( rule__Item__ItemNameAssignment_2 )
            // InternalMyDsl.g:175:3: rule__Item__ItemNameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Item__ItemNameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getItemAccess().getItemNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__Group__2__Impl"


    // $ANTLR start "rule__Item__Group__3"
    // InternalMyDsl.g:183:1: rule__Item__Group__3 : rule__Item__Group__3__Impl rule__Item__Group__4 ;
    public final void rule__Item__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:187:1: ( rule__Item__Group__3__Impl rule__Item__Group__4 )
            // InternalMyDsl.g:188:2: rule__Item__Group__3__Impl rule__Item__Group__4
            {
            pushFollow(FOLLOW_6);
            rule__Item__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Item__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__Group__3"


    // $ANTLR start "rule__Item__Group__3__Impl"
    // InternalMyDsl.g:195:1: rule__Item__Group__3__Impl : ( ( rule__Item__DescriptionAssignment_3 )? ) ;
    public final void rule__Item__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:199:1: ( ( ( rule__Item__DescriptionAssignment_3 )? ) )
            // InternalMyDsl.g:200:1: ( ( rule__Item__DescriptionAssignment_3 )? )
            {
            // InternalMyDsl.g:200:1: ( ( rule__Item__DescriptionAssignment_3 )? )
            // InternalMyDsl.g:201:2: ( rule__Item__DescriptionAssignment_3 )?
            {
             before(grammarAccess.getItemAccess().getDescriptionAssignment_3()); 
            // InternalMyDsl.g:202:2: ( rule__Item__DescriptionAssignment_3 )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_STRING) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalMyDsl.g:202:3: rule__Item__DescriptionAssignment_3
                    {
                    pushFollow(FOLLOW_2);
                    rule__Item__DescriptionAssignment_3();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getItemAccess().getDescriptionAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__Group__3__Impl"


    // $ANTLR start "rule__Item__Group__4"
    // InternalMyDsl.g:210:1: rule__Item__Group__4 : rule__Item__Group__4__Impl ;
    public final void rule__Item__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:214:1: ( rule__Item__Group__4__Impl )
            // InternalMyDsl.g:215:2: rule__Item__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Item__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__Group__4"


    // $ANTLR start "rule__Item__Group__4__Impl"
    // InternalMyDsl.g:221:1: rule__Item__Group__4__Impl : ( ( rule__Item__ItemWeightAssignment_4 ) ) ;
    public final void rule__Item__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:225:1: ( ( ( rule__Item__ItemWeightAssignment_4 ) ) )
            // InternalMyDsl.g:226:1: ( ( rule__Item__ItemWeightAssignment_4 ) )
            {
            // InternalMyDsl.g:226:1: ( ( rule__Item__ItemWeightAssignment_4 ) )
            // InternalMyDsl.g:227:2: ( rule__Item__ItemWeightAssignment_4 )
            {
             before(grammarAccess.getItemAccess().getItemWeightAssignment_4()); 
            // InternalMyDsl.g:228:2: ( rule__Item__ItemWeightAssignment_4 )
            // InternalMyDsl.g:228:3: rule__Item__ItemWeightAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__Item__ItemWeightAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getItemAccess().getItemWeightAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__Group__4__Impl"


    // $ANTLR start "rule__Model__ItemAssignment"
    // InternalMyDsl.g:237:1: rule__Model__ItemAssignment : ( ruleItem ) ;
    public final void rule__Model__ItemAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:241:1: ( ( ruleItem ) )
            // InternalMyDsl.g:242:2: ( ruleItem )
            {
            // InternalMyDsl.g:242:2: ( ruleItem )
            // InternalMyDsl.g:243:3: ruleItem
            {
             before(grammarAccess.getModelAccess().getItemItemParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleItem();

            state._fsp--;

             after(grammarAccess.getModelAccess().getItemItemParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__ItemAssignment"


    // $ANTLR start "rule__Item__ItemIDAssignment_1"
    // InternalMyDsl.g:252:1: rule__Item__ItemIDAssignment_1 : ( RULE_ID ) ;
    public final void rule__Item__ItemIDAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:256:1: ( ( RULE_ID ) )
            // InternalMyDsl.g:257:2: ( RULE_ID )
            {
            // InternalMyDsl.g:257:2: ( RULE_ID )
            // InternalMyDsl.g:258:3: RULE_ID
            {
             before(grammarAccess.getItemAccess().getItemIDIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getItemAccess().getItemIDIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__ItemIDAssignment_1"


    // $ANTLR start "rule__Item__ItemNameAssignment_2"
    // InternalMyDsl.g:267:1: rule__Item__ItemNameAssignment_2 : ( RULE_STRING ) ;
    public final void rule__Item__ItemNameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:271:1: ( ( RULE_STRING ) )
            // InternalMyDsl.g:272:2: ( RULE_STRING )
            {
            // InternalMyDsl.g:272:2: ( RULE_STRING )
            // InternalMyDsl.g:273:3: RULE_STRING
            {
             before(grammarAccess.getItemAccess().getItemNameSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getItemAccess().getItemNameSTRINGTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__ItemNameAssignment_2"


    // $ANTLR start "rule__Item__DescriptionAssignment_3"
    // InternalMyDsl.g:282:1: rule__Item__DescriptionAssignment_3 : ( RULE_STRING ) ;
    public final void rule__Item__DescriptionAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:286:1: ( ( RULE_STRING ) )
            // InternalMyDsl.g:287:2: ( RULE_STRING )
            {
            // InternalMyDsl.g:287:2: ( RULE_STRING )
            // InternalMyDsl.g:288:3: RULE_STRING
            {
             before(grammarAccess.getItemAccess().getDescriptionSTRINGTerminalRuleCall_3_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getItemAccess().getDescriptionSTRINGTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__DescriptionAssignment_3"


    // $ANTLR start "rule__Item__ItemWeightAssignment_4"
    // InternalMyDsl.g:297:1: rule__Item__ItemWeightAssignment_4 : ( RULE_INT ) ;
    public final void rule__Item__ItemWeightAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:301:1: ( ( RULE_INT ) )
            // InternalMyDsl.g:302:2: ( RULE_INT )
            {
            // InternalMyDsl.g:302:2: ( RULE_INT )
            // InternalMyDsl.g:303:3: RULE_INT
            {
             before(grammarAccess.getItemAccess().getItemWeightINTTerminalRuleCall_4_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getItemAccess().getItemWeightINTTerminalRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__ItemWeightAssignment_4"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000060L});

}