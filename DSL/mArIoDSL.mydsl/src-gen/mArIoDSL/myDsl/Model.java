/**
 * generated by Xtext 2.24.0
 */
package mArIoDSL.myDsl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link mArIoDSL.myDsl.Model#getItem <em>Item</em>}</li>
 * </ul>
 *
 * @see mArIoDSL.myDsl.MyDslPackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject
{
  /**
   * Returns the value of the '<em><b>Item</b></em>' containment reference list.
   * The list contents are of type {@link mArIoDSL.myDsl.Item}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Item</em>' containment reference list.
   * @see mArIoDSL.myDsl.MyDslPackage#getModel_Item()
   * @model containment="true"
   * @generated
   */
  EList<Item> getItem();

} // Model
