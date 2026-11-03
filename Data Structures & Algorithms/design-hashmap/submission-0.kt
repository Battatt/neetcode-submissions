data class Entry(val key: Int, val value: Int)

class MyHashMap() {
    var size = 0
        private set

    private var elements: Array<MutableList<Entry>> = Array(DEFAULT_CAPACITY) { mutableListOf() }
    private val capacity: Int
        get() = elements.size

    private fun hash(key: Int): Int {
        return key % capacity
    }

    private fun resize() {
        size = 0
        val oldElements = elements
        elements = Array(capacity * RESIZE_RATIO) { mutableListOf() }

        for (bucket in oldElements) {
            for ((key, value) in bucket) {
                this.put(key, value)
            }
        }
    }

    private fun checkOverflow() {
        if (size / capacity.toDouble() >= OVERFLOW_PERCENT) {
            resize()
        }
    }

    fun put(key: Int, value: Int) {
        val elementHash = hash(key)

        val bucket = elements[elementHash]
        val index = bucket.indexOfFirst { it.key == key }
        if (index != -1) {
            bucket[index] = Entry(key, value)
        } else {
            bucket.add(Entry(key, value))
            size++
            checkOverflow()
        }
    }

    fun get(key: Int): Int {
        val elementHash = hash(key)
        val bucket = elements[elementHash]
        val index = bucket.indexOfFirst { it.key == key }
        return if (index == -1) index else bucket[index].value
    }

    fun remove(key: Int) {
        val elementHash = hash(key)
        val bucket = elements[elementHash]

        val index = bucket.indexOfFirst { it.key == key }

        if (index != -1) {
            bucket.removeAt(index)
            size--
        }
    }

    companion object {
        private const val DEFAULT_CAPACITY = 10
        private const val OVERFLOW_PERCENT = 0.75
        private const val RESIZE_RATIO = 2
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * var obj = MyHashMap()
 * obj.put(key,value)
 * var param_2 = obj.get(key)
 * obj.remove(key)
 */
