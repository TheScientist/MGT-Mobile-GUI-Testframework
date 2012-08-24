/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.tu_dresden.mgt.resource.mgt.grammar;

/**
 * The abstract super class for all elements of a grammar. This class provides
 * methods to traverse the grammar rules.
 */
public abstract class MgtSyntaxElement {
	
	private MgtSyntaxElement[] children;
	private MgtSyntaxElement parent;
	private de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality cardinality;
	
	public MgtSyntaxElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality cardinality, MgtSyntaxElement[] children) {
		this.cardinality = cardinality;
		this.children = children;
		if (this.children != null) {
			for (MgtSyntaxElement child : this.children) {
				child.setParent(this);
			}
		}
	}
	
	/**
	 * Sets the parent of this syntax element. This method must be invoked at most
	 * once.
	 */
	public void setParent(MgtSyntaxElement parent) {
		assert this.parent == null;
		this.parent = parent;
	}
	
	/**
	 * Returns the parent of this syntax element. This parent is determined by the
	 * containment hierarchy in the CS model.
	 */
	public MgtSyntaxElement getParent() {
		return parent;
	}
	
	public MgtSyntaxElement[] getChildren() {
		if (children == null) {
			return new MgtSyntaxElement[0];
		}
		return children;
	}
	
	public org.eclipse.emf.ecore.EClass getMetaclass() {
		return parent.getMetaclass();
	}
	
	public de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality getCardinality() {
		return cardinality;
	}
	
}
