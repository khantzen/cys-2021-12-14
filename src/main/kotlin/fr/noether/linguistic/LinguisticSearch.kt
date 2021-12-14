package fr.noether.linguistic

class LinguisticSearch {
    fun search(searchPattern: SearchPattern, text: TextContent): SearchResult {
        if (!text.match(searchPattern)) {
            return SearchResult.empty()
        }

        return SearchResult.empty()
            .append(text.word)
    }

}
