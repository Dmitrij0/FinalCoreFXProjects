package com.gojavaonline3.shkurupiy.finalcore.dlenchuk.collections.traversal;

import java.util.Iterator;


/**
 * The contract of a binary-tree traversal
 *
 * @author  Dmitrij Lenchuk
 */
public interface Traversal<T> {

    Iterator<T> preOrderIterator();

    Iterator<T> inOrderIterator();

    Iterator<T> postOrderIterator();

}
