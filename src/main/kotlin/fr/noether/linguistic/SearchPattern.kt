package fr.noether.linguistic

data class SearchPattern(val posTag: PosTag?) {
    fun addPattern(posTag: PosTag): SearchPattern {
        return SearchPattern(posTag)
    }

    companion object {
        fun empty() = SearchPattern(PosTag.NONE)
    }
}
