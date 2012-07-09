/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.tu_dresden.mgt.resource.mgt.util;

/**
 * This class provides basic infrastructure to interpret models. To implement
 * concrete interpreters, subclass this abstract interpreter and override the
 * interprete_* methods. The interpretation can be customized by binding the two
 * type parameters (ResultType, ContextType). The former is returned by all
 * interprete_* methods, while the latter is passed from method to method while
 * traversing the model. The concrete traversal strategy can also be exchanged.
 * One can use a static traversal strategy by pushing all objects to interpret on
 * the interpretation stack (using addObjectToInterprete()) before calling
 * interprete(). Alternatively, the traversal strategy can be dynamic by pushing
 * objects on the interpretation stack during interpretation.
 */
public class AbstractMgtInterpreter<ResultType, ContextType> {
	
	private java.util.Stack<org.eclipse.emf.ecore.EObject> interpretationStack = new java.util.Stack<org.eclipse.emf.ecore.EObject>();
	private java.util.List<de.tu_dresden.mgt.resource.mgt.IMgtInterpreterListener> listeners = new java.util.ArrayList<de.tu_dresden.mgt.resource.mgt.IMgtInterpreterListener>();
	private org.eclipse.emf.ecore.EObject nextObjectToInterprete;
	private Object currentContext;
	
	public ResultType interprete(ContextType context) {
		ResultType result = null;
		org.eclipse.emf.ecore.EObject next = null;
		currentContext = context;
		while (!interpretationStack.empty()) {
			try {
				next = interpretationStack.pop();
			} catch (java.util.EmptyStackException ese) {
				// this can happen when the interpreter was terminated between the call to empty()
				// and pop()
				break;
			}
			nextObjectToInterprete = next;
			notifyListeners(next);
			result = interprete(next, context);
			if (!continueInterpretation(context, result)) {
				break;
			}
		}
		currentContext = null;
		return result;
	}
	
	/**
	 * Override this method to stop the overall interpretation depending on the result
	 * of the interpretation of a single model elements.
	 */
	public boolean continueInterpretation(ContextType context, ResultType result) {
		return true;
	}
	
	public ResultType interprete(org.eclipse.emf.ecore.EObject object, ContextType context) {
		ResultType result = null;
		if (object instanceof de.tu_dresden.mgt.Float) {
			result = interprete_de_tu_005fdresden_mgt_Float((de.tu_dresden.mgt.Float) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof de.tu_dresden.mgt.SequentialStep) {
			result = interprete_de_tu_005fdresden_mgt_SequentialStep((de.tu_dresden.mgt.SequentialStep) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof de.tu_dresden.mgt.Sequence) {
			result = interprete_de_tu_005fdresden_mgt_Sequence((de.tu_dresden.mgt.Sequence) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof de.tu_dresden.mgt.UIElementLocator) {
			result = interprete_de_tu_005fdresden_mgt_UIElementLocator((de.tu_dresden.mgt.UIElementLocator) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof de.tu_dresden.mgt.Keyword) {
			result = interprete_de_tu_005fdresden_mgt_Keyword((de.tu_dresden.mgt.Keyword) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof de.tu_dresden.mgt.Assertion) {
			result = interprete_de_tu_005fdresden_mgt_Assertion((de.tu_dresden.mgt.Assertion) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof de.tu_dresden.mgt.String) {
			result = interprete_de_tu_005fdresden_mgt_String((de.tu_dresden.mgt.String) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof de.tu_dresden.mgt.Boolean) {
			result = interprete_de_tu_005fdresden_mgt_Boolean((de.tu_dresden.mgt.Boolean) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof de.tu_dresden.mgt.Integer) {
			result = interprete_de_tu_005fdresden_mgt_Integer((de.tu_dresden.mgt.Integer) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof de.tu_dresden.mgt.TestDate) {
			result = interprete_de_tu_005fdresden_mgt_TestDate((de.tu_dresden.mgt.TestDate) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof de.tu_dresden.mgt.AbstractTestStep) {
			result = interprete_de_tu_005fdresden_mgt_AbstractTestStep((de.tu_dresden.mgt.AbstractTestStep) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof de.tu_dresden.mgt.TestCase) {
			result = interprete_de_tu_005fdresden_mgt_TestCase((de.tu_dresden.mgt.TestCase) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof de.tu_dresden.mgt.TestSuite) {
			result = interprete_de_tu_005fdresden_mgt_TestSuite((de.tu_dresden.mgt.TestSuite) object, context);
		}
		if (result != null) {
			return result;
		}
		return result;
	}
	
	public ResultType interprete_de_tu_005fdresden_mgt_TestSuite(de.tu_dresden.mgt.TestSuite object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_de_tu_005fdresden_mgt_TestCase(de.tu_dresden.mgt.TestCase object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_de_tu_005fdresden_mgt_AbstractTestStep(de.tu_dresden.mgt.AbstractTestStep object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_de_tu_005fdresden_mgt_TestDate(de.tu_dresden.mgt.TestDate object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_de_tu_005fdresden_mgt_Integer(de.tu_dresden.mgt.Integer object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_de_tu_005fdresden_mgt_Boolean(de.tu_dresden.mgt.Boolean object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_de_tu_005fdresden_mgt_String(de.tu_dresden.mgt.String object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_de_tu_005fdresden_mgt_Assertion(de.tu_dresden.mgt.Assertion object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_de_tu_005fdresden_mgt_Keyword(de.tu_dresden.mgt.Keyword object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_de_tu_005fdresden_mgt_UIElementLocator(de.tu_dresden.mgt.UIElementLocator object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_de_tu_005fdresden_mgt_Sequence(de.tu_dresden.mgt.Sequence object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_de_tu_005fdresden_mgt_SequentialStep(de.tu_dresden.mgt.SequentialStep object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_de_tu_005fdresden_mgt_Float(de.tu_dresden.mgt.Float object, ContextType context) {
		return null;
	}
	
	private void notifyListeners(org.eclipse.emf.ecore.EObject element) {
		for (de.tu_dresden.mgt.resource.mgt.IMgtInterpreterListener listener : listeners) {
			listener.handleInterpreteObject(element);
		}
	}
	
	/**
	 * Adds the given object to the interpretation stack. Attention: Objects that are
	 * added first, are interpret last.
	 */
	public void addObjectToInterprete(org.eclipse.emf.ecore.EObject object) {
		interpretationStack.push(object);
	}
	
	/**
	 * Adds the given collection of objects to the interpretation stack. Attention:
	 * Collections that are added first, are interpret last.
	 */
	public void addObjectsToInterprete(java.util.Collection<? extends org.eclipse.emf.ecore.EObject> objects) {
		for (org.eclipse.emf.ecore.EObject object : objects) {
			addObjectToInterprete(object);
		}
	}
	
	/**
	 * Adds the given collection of objects in reverse order to the interpretation
	 * stack.
	 */
	public void addObjectsToInterpreteInReverseOrder(java.util.Collection<? extends org.eclipse.emf.ecore.EObject> objects) {
		java.util.List<org.eclipse.emf.ecore.EObject> reverse = new java.util.ArrayList<org.eclipse.emf.ecore.EObject>(objects.size());
		reverse.addAll(objects);
		java.util.Collections.reverse(reverse);
		addObjectsToInterprete(reverse);
	}
	
	/**
	 * Adds the given object and all its children to the interpretation stack such
	 * that they are interpret in top down order.
	 */
	public void addObjectTreeToInterpreteTopDown(org.eclipse.emf.ecore.EObject root) {
		java.util.List<org.eclipse.emf.ecore.EObject> objects = new java.util.ArrayList<org.eclipse.emf.ecore.EObject>();
		objects.add(root);
		java.util.Iterator<org.eclipse.emf.ecore.EObject> it = root.eAllContents();
		while (it.hasNext()) {
			org.eclipse.emf.ecore.EObject eObject = (org.eclipse.emf.ecore.EObject) it.next();
			objects.add(eObject);
		}
		addObjectsToInterpreteInReverseOrder(objects);
	}
	
	public void addListener(de.tu_dresden.mgt.resource.mgt.IMgtInterpreterListener newListener) {
		listeners.add(newListener);
	}
	
	public boolean removeListener(de.tu_dresden.mgt.resource.mgt.IMgtInterpreterListener listener) {
		return listeners.remove(listener);
	}
	
	public org.eclipse.emf.ecore.EObject getNextObjectToInterprete() {
		return nextObjectToInterprete;
	}
	
	public java.util.Stack<org.eclipse.emf.ecore.EObject> getInterpretationStack() {
		return interpretationStack;
	}
	
	public void terminate() {
		interpretationStack.clear();
	}
	
	public Object getCurrentContext() {
		return currentContext;
	}
	
}
