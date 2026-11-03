sealed interface Entry {
    object Empty : Entry
    object Deleted : Entry
    data class Occupied(val value: Int) : Entry
}

class MyHashSet {
    private var elements: Array<Entry> = Array(DEFAULT_CAPACITY) { Entry.Empty }
    private val capacity: Int
        get() = elements.size

    var size = 0
        private set

    private fun hash(key: Int): Int {
        return key % capacity
    }

    private fun resize() {
        val oldElements = elements
        elements = Array(capacity * RESIZE_RATIO) { Entry.Empty }
        size = 0
        for (element in oldElements) {
            if (element is Entry.Occupied) {
                this.add(element.value)
            }
        }
    }

    private fun checkOverflow(): Boolean {
        return (size / capacity.toDouble() >= OVERFLOW_PERCENT)
    }

    fun add(key: Int) {
        var elementHash = hash(key)
        val startHash = elementHash
        var firstDeletedHash = -1
        while (true) {
            val element = elements[elementHash]

            if (element is Entry.Occupied) {
                if (element.value == key) {
                    return
                }
            }

            if (element is Entry.Deleted) {
                if (firstDeletedHash == -1) firstDeletedHash = elementHash
            }

            if (element is Entry.Empty) {
                val index = if (firstDeletedHash == -1) elementHash else firstDeletedHash
                return insertInIndex(key, index)
            }

            elementHash = (elementHash + 1) % capacity
            if (elementHash == startHash) {
                if (firstDeletedHash == -1) throw RuntimeException("what a terrible failure")
                return insertInIndex(key, firstDeletedHash)
            }
        }
    }

    private fun insertInIndex(key: Int, index: Int) {
        elements[index] = Entry.Occupied(key)
        size++

        if (checkOverflow()) {
            resize()
        }
    }

    fun remove(key: Int) {
        val startHash = hash(key)
        var elementHash = startHash

        while (true) {
            when (val element = elements[elementHash]) {
                is Entry.Empty -> return
                is Entry.Occupied -> {
                    if (element.value == key) {
                        elements[elementHash] = Entry.Deleted
                        size--
                        return
                    }
                }

                is Entry.Deleted -> {}
            }
            elementHash = (elementHash + 1) % capacity
            if (elementHash == startHash) {
                return
            }
        }
    }

    fun contains(key: Int): Boolean {
        val startHash = hash(key)
        var elementHash = startHash

        while (true) {
            when (val element = elements[elementHash]) {
                is Entry.Empty -> return false
                is Entry.Occupied -> {
                    if (element.value == key) return true
                }

                is Entry.Deleted -> {}
            }
            elementHash = (elementHash + 1) % capacity
            if (elementHash == startHash) {
                return false
            }
        }
    }

    companion object {
        private const val DEFAULT_CAPACITY = 10
        private const val OVERFLOW_PERCENT = 0.75
        private const val RESIZE_RATIO = 2
    }
}