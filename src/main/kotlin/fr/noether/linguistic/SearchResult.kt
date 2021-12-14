package fr.noether.linguistic

data class SearchResult(val word: String) {
    fun isEmpty() = word == ""
    fun append(s: String): SearchResult {
        return SearchResult(s)
    }

    companion object {
        fun empty() = SearchResult("")
    }

}
