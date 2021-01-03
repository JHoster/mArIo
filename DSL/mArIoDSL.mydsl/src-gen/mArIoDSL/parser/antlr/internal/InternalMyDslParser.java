package mArIoDSL.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import mArIoDSL.services.MyDslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMyDslParser extends AbstractInternalAntlrParser {
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

        public InternalMyDslParser(TokenStream input, MyDslGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Model";
       	}

       	@Override
       	protected MyDslGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleModel"
    // InternalMyDsl.g:64:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalMyDsl.g:64:46: (iv_ruleModel= ruleModel EOF )
            // InternalMyDsl.g:65:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalMyDsl.g:71:1: ruleModel returns [EObject current=null] : ( (lv_item_0_0= ruleItem ) )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_item_0_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:77:2: ( ( (lv_item_0_0= ruleItem ) )* )
            // InternalMyDsl.g:78:2: ( (lv_item_0_0= ruleItem ) )*
            {
            // InternalMyDsl.g:78:2: ( (lv_item_0_0= ruleItem ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalMyDsl.g:79:3: (lv_item_0_0= ruleItem )
            	    {
            	    // InternalMyDsl.g:79:3: (lv_item_0_0= ruleItem )
            	    // InternalMyDsl.g:80:4: lv_item_0_0= ruleItem
            	    {

            	    				newCompositeNode(grammarAccess.getModelAccess().getItemItemParserRuleCall_0());
            	    			
            	    pushFollow(FOLLOW_3);
            	    lv_item_0_0=ruleItem();

            	    state._fsp--;


            	    				if (current==null) {
            	    					current = createModelElementForParent(grammarAccess.getModelRule());
            	    				}
            	    				add(
            	    					current,
            	    					"item",
            	    					lv_item_0_0,
            	    					"mArIoDSL.MyDsl.Item");
            	    				afterParserOrEnumRuleCall();
            	    			

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleItem"
    // InternalMyDsl.g:100:1: entryRuleItem returns [EObject current=null] : iv_ruleItem= ruleItem EOF ;
    public final EObject entryRuleItem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleItem = null;


        try {
            // InternalMyDsl.g:100:45: (iv_ruleItem= ruleItem EOF )
            // InternalMyDsl.g:101:2: iv_ruleItem= ruleItem EOF
            {
             newCompositeNode(grammarAccess.getItemRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleItem=ruleItem();

            state._fsp--;

             current =iv_ruleItem; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleItem"


    // $ANTLR start "ruleItem"
    // InternalMyDsl.g:107:1: ruleItem returns [EObject current=null] : (otherlv_0= 'Item' ( (lv_ItemID_1_0= RULE_ID ) ) ( (lv_ItemName_2_0= RULE_STRING ) ) ( (lv_description_3_0= RULE_STRING ) )? ( (lv_ItemWeight_4_0= RULE_INT ) ) ) ;
    public final EObject ruleItem() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_ItemID_1_0=null;
        Token lv_ItemName_2_0=null;
        Token lv_description_3_0=null;
        Token lv_ItemWeight_4_0=null;


        	enterRule();

        try {
            // InternalMyDsl.g:113:2: ( (otherlv_0= 'Item' ( (lv_ItemID_1_0= RULE_ID ) ) ( (lv_ItemName_2_0= RULE_STRING ) ) ( (lv_description_3_0= RULE_STRING ) )? ( (lv_ItemWeight_4_0= RULE_INT ) ) ) )
            // InternalMyDsl.g:114:2: (otherlv_0= 'Item' ( (lv_ItemID_1_0= RULE_ID ) ) ( (lv_ItemName_2_0= RULE_STRING ) ) ( (lv_description_3_0= RULE_STRING ) )? ( (lv_ItemWeight_4_0= RULE_INT ) ) )
            {
            // InternalMyDsl.g:114:2: (otherlv_0= 'Item' ( (lv_ItemID_1_0= RULE_ID ) ) ( (lv_ItemName_2_0= RULE_STRING ) ) ( (lv_description_3_0= RULE_STRING ) )? ( (lv_ItemWeight_4_0= RULE_INT ) ) )
            // InternalMyDsl.g:115:3: otherlv_0= 'Item' ( (lv_ItemID_1_0= RULE_ID ) ) ( (lv_ItemName_2_0= RULE_STRING ) ) ( (lv_description_3_0= RULE_STRING ) )? ( (lv_ItemWeight_4_0= RULE_INT ) )
            {
            otherlv_0=(Token)match(input,11,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getItemAccess().getItemKeyword_0());
            		
            // InternalMyDsl.g:119:3: ( (lv_ItemID_1_0= RULE_ID ) )
            // InternalMyDsl.g:120:4: (lv_ItemID_1_0= RULE_ID )
            {
            // InternalMyDsl.g:120:4: (lv_ItemID_1_0= RULE_ID )
            // InternalMyDsl.g:121:5: lv_ItemID_1_0= RULE_ID
            {
            lv_ItemID_1_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(lv_ItemID_1_0, grammarAccess.getItemAccess().getItemIDIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getItemRule());
            					}
            					setWithLastConsumed(
            						current,
            						"ItemID",
            						lv_ItemID_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalMyDsl.g:137:3: ( (lv_ItemName_2_0= RULE_STRING ) )
            // InternalMyDsl.g:138:4: (lv_ItemName_2_0= RULE_STRING )
            {
            // InternalMyDsl.g:138:4: (lv_ItemName_2_0= RULE_STRING )
            // InternalMyDsl.g:139:5: lv_ItemName_2_0= RULE_STRING
            {
            lv_ItemName_2_0=(Token)match(input,RULE_STRING,FOLLOW_6); 

            					newLeafNode(lv_ItemName_2_0, grammarAccess.getItemAccess().getItemNameSTRINGTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getItemRule());
            					}
            					setWithLastConsumed(
            						current,
            						"ItemName",
            						lv_ItemName_2_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalMyDsl.g:155:3: ( (lv_description_3_0= RULE_STRING ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_STRING) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalMyDsl.g:156:4: (lv_description_3_0= RULE_STRING )
                    {
                    // InternalMyDsl.g:156:4: (lv_description_3_0= RULE_STRING )
                    // InternalMyDsl.g:157:5: lv_description_3_0= RULE_STRING
                    {
                    lv_description_3_0=(Token)match(input,RULE_STRING,FOLLOW_7); 

                    					newLeafNode(lv_description_3_0, grammarAccess.getItemAccess().getDescriptionSTRINGTerminalRuleCall_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getItemRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"description",
                    						lv_description_3_0,
                    						"org.eclipse.xtext.common.Terminals.STRING");
                    				

                    }


                    }
                    break;

            }

            // InternalMyDsl.g:173:3: ( (lv_ItemWeight_4_0= RULE_INT ) )
            // InternalMyDsl.g:174:4: (lv_ItemWeight_4_0= RULE_INT )
            {
            // InternalMyDsl.g:174:4: (lv_ItemWeight_4_0= RULE_INT )
            // InternalMyDsl.g:175:5: lv_ItemWeight_4_0= RULE_INT
            {
            lv_ItemWeight_4_0=(Token)match(input,RULE_INT,FOLLOW_2); 

            					newLeafNode(lv_ItemWeight_4_0, grammarAccess.getItemAccess().getItemWeightINTTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getItemRule());
            					}
            					setWithLastConsumed(
            						current,
            						"ItemWeight",
            						lv_ItemWeight_4_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleItem"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000040L});

}