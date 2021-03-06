import java.util.List;
import java.util.Collection;
import java.util.ListIterator;
import java.util.Iterator;
import java.util.NoSuchElementException;
public class LinkedList<T> implements List<T> {

    private Item<T> first = null;

    private Item<T> last = null;

    private int size;

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public boolean contains(final Object o) {
        // BEGIN (write your solution here)
        Item<T> x = first;
        while (x != null) {
            if (x.getElement().equals(o)) {
                return true;
            }
            x = x.next;
        }
        return false;
        // END
    }

    @Override
    public Iterator<T> iterator() {
        return new ElementsIterator();

    }

    @Override
    public Object[] toArray() {
        // BEGIN (write your solution here)
        final Object[] returnedArray = new Object[this.size()];
        Item<T> x = first;
        int i = 0;
        while (x != null) {
            returnedArray[i] = x.getElement();
            x = x.next;
            i++;
        }
        return returnedArray;
        // END
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        // BEGIN (write your solution here)
        if (a.length < size)
            a = (T1[])java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size);
        int i = 0;
        Object[] result = a;
        Item<T> x = first;
        while (x!=null) {
            result[i++] = x.getElement();
            x = x.next;
        }
        if (a.length > size)
            a[size] = null;
        return a;
        // END
    }

    @Override
    public boolean add(final T t) {
        // BEGIN (write your solution here)
        if (this.isEmpty()){
            Item<T> newItem = new Item<>(t, first, last);
            first = newItem;
            last = newItem;
            size++;
        }
        else {
            Item<T> newItem = new Item<>(t, last, null);
            last.next = newItem;
            last = newItem;
            size++;
        }
        return true;
        // END
    }

    @Override
    public boolean remove(final Object o) {
        // BEGIN (write your solution here)
        Item<T> x = first;
        while (x != null) {
            if (x.getElement().equals(o)) {
                if (x.prev!=null) {
                    x.prev.next = x.next;
                }
                else {
                    first = x.next;
                }
                if (x.next!=null) {
                    x.next.prev = x.prev;
                }
                else {
                    last = x.prev;
                }
                size--;
                return true;
            }
            x = x.next;
        }
        return false;
        // END
    }

    @Override
    public boolean containsAll(final Collection<?> c) {
        for (final Object item : c) {
            if (!this.contains(item)) return false;
        }
        return true;
    }

    @Override
    public boolean addAll(final Collection<? extends T> c) {
        for (final T item : c) {
            add(item);
        }
        return true;
    }

    @Override
    public boolean removeAll(final Collection<?> c) {
        for (final Object item : c) {
            remove(item);
        }
        return true;
    }

    @Override
    public boolean retainAll(final Collection<?> c) {
        for (final Object item : this) {
            if (!c.contains(item)) this.remove(item);
        }
        return true;
    }

    @Override
    public void clear() {
        // BEGIN (write your solution here)
        Item<T> x = first;
        while (x != null) {
            x.prev = null;
            x.next = null;
            x = x.next;
        }
        first = null;
        last = null;
        size = 0;
        // END
    }

    @Override
    public T remove(final int index) {
        // BEGIN (write your solution here)
        checkIndex(index);
        if (index == 0) {
            Item<T> returnedItem = first;
            first = first.next;
            size--;
            return returnedItem.getElement();
        }
        else if (index == size - 1) {
            Item<T> returnedItem = last;
            last = last.prev;
            size--;
            return returnedItem.getElement();
        }
        else {
            if (index < size/2) {
                Item<T> x = first;
                for(int i = 0; i < size / 2; i++) {
                    if (i == index) {
                        x.prev.next = x.next;
                        x.next.prev = x.prev;
                        size--;
                        return x.getElement();
                    }
                    x = x.next;
                }
            }
            else {
                Item<T> x = last;
                for(int i = size - 1; i >= size / 2; i--) {
                    if (i == index) {
                        x.prev.next = x.next;
                        x.next.prev = x.prev;
                        size--;
                        return x.getElement();
                    }
                    x = x.prev;
                }
            }

        }
        return null;
        // END
    }

    // BEGIN (write your solution here)

    // END
    @Override
    public List<T> subList(final int start, final int end) {
        return null;
    }

    @Override
    public ListIterator listIterator() {
        return new ElementsIterator(0);
    }

    @Override
    public ListIterator listIterator(final int index) {
        return new ElementsIterator(index);
    }

    @Override
    public int lastIndexOf(final Object target) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int indexOf(final Object target) {
        // BEGIN (write your solution here)
        Item<T> x = first;
        int i = 0;
        while (x != null) {
            if (x.equals(target)) {
                return i;
            }
            i++;
            x = x.next;
        }
        return -1;
        // END
    }

    @Override
    public void add(final int index, final T element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(final int index, final Collection elements) {
        throw new UnsupportedOperationException();
    }

//    @Override
    public T set(final int index, final T element) {
        // BEGIN (write your solution here)
        checkIndex(index);
        if (index == 0) {
            Item<T> returnedItem = first;
            Item<T> newItem = new Item<>(element, null, first.next);
            if (size > 1) {
                first.next.prev = newItem;
            }
            first = newItem;
            return returnedItem.getElement();
        }
        else if (index == size - 1) {
            Item<T> returnedItem = last;
            Item<T> newItem = new Item<>(element, last.prev, null);
            last.prev.next = newItem;
            last = newItem;
            return returnedItem.getElement();
        }
        else {
            if (index < size/2) {
                Item<T> x = first;
                for(int i = 0; i < size / 2; i++) {
                    if (i == index) {
                        Item<T> returnedItem = x;
                        Item<T> newItem;
                        newItem = new Item<>(element, x.prev, x.next);
                        x.prev.next = newItem;
                        x.next.prev = newItem;
                        x = newItem;
                        return returnedItem.getElement();
                    }
                    x = x.next;
                }
            }
            else {
                Item<T> x = last;
                for(int i = size - 1; i >= size / 2; i--) {
                    if (i == index) {
                        Item<T> returnedItem = x;
                        Item<T> newItem;
                        newItem = new Item<>(element, x.prev, x.next);
                        x.prev.next = newItem;
                        x.next.prev = newItem;
                        x = newItem;
                        return returnedItem.getElement();
                    }
                    x = x.prev;
                }
            }
        }
        return null;
        // END
    }

    @Override
    public T get(final int index) {
        // BEGIN (write your solution here)
        checkIndex(index);
        Item<T> x = first;
        int i = 0;
        while (x != null) {
            if (i == index) {
                return x.getElement();
            }
            i++;
            x = x.next;
        }
        return null;
        // END
    }

    // BEGIN (write your solution here)
    private void checkIndex(final int index) {
        if (index < 0 || index >= size() && size()!= 0) {
            throw new IndexOutOfBoundsException();
        }
    }
    // END

    private class ElementsIterator implements ListIterator<T> {

        private Item<T> current;

        private Item<T> last;

        private int position = -1;

        public ElementsIterator() {
            this(0);
        }

        public ElementsIterator(final int index) {
            // BEGIN (write your solution here)
            checkIndex(index);
            Item<T> x = first;
            int i = 0;
            while (x != null) {
                if (i == index) {
                    this.current = x;
                }
                x = x.next;
                i++;
            }
            // END
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            // BEGIN (write your solution here)
            if (!hasNext())
                throw new NoSuchElementException();
            last = current;
            current = current.next;
            position++;
            return last.getElement();
            // END
        }

        @Override
        public void add(final T element) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void set(final T element) {
            // BEGIN (write your solution here)
            if (last == null)
                throw new IllegalStateException();
            LinkedList.this.set(position, element);
            // END
        }

        @Override
        public int previousIndex(){
            // BEGIN (write your solution here)
            if (position == -1)
                return -1;
            return position;
            // END
        }

        @Override
        public int nextIndex() {
            // BEGIN (write your solution here)
            if (position == size)
                return size;
            return position + 1;
            // END
        }

        @Override
        public boolean hasPrevious() {
            return position > -1;
            // END
        }

        @Override
        public T previous() {
            // BEGIN (write your solution here)
            if (!hasPrevious())
                throw new NoSuchElementException();
            current = last;
            position--;
            return last.getElement();
            // END
        }

        @Override
        public void remove() {
            // BEGIN (write your solution here)
            if (last == null) throw new IllegalStateException();
            LinkedList.this.remove(position);
            position--;
            last = null;
            // END
        }

    }

    private static class Item<T> {

        private T element;

        private Item<T> next;

        private Item<T> prev;

        public Item(final T element, final Item<T> prev, final Item<T> next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }

        public T getElement() {
            return element;
        }

        public Item<T> getNext() {
            return next;
        }

        public Item<T> getPrev() {
            return prev;
        }
    }
}
