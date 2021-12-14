package fr.noether.linguistic

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class ToBeNamedTest {

    @Test
    fun `search nothing in nothing should return nothing`() {
        val linguisticSearch = LinguisticSearch()
        val searchResult = linguisticSearch
            .search(SearchPattern.empty(), TextContent.empty())
        assertThat(searchResult.isEmpty()).isTrue
    }

    @Test
    fun `One word matching pattern should have a non empty result`() {
        val linguisticSearch = LinguisticSearch()

        val textContent = TextContent.empty()
            .addWord("talk", PosTag.NOUN)

        val searchPattern = SearchPattern.empty()
            .addPattern(PosTag.NOUN)

        val searchResult =
            linguisticSearch.search(searchPattern, textContent)

        assertThat(searchResult.isEmpty()).isFalse
    }

    @Test
    fun `One word matching pattern should return the matching word`() {
        val linguisticSearch = LinguisticSearch()

        val textContent = TextContent.empty()
            .addWord("Cabbages", PosTag.NOUN)

        val searchPattern = SearchPattern.empty()
            .addPattern(PosTag.NOUN)

        val searchResult =
            linguisticSearch.search(searchPattern, textContent)

        assertThat(searchResult.isEmpty()).isFalse

        val expectedSearchResult = SearchResult.empty()
            .append("Cabbages")

        assertThat(searchResult).isEqualTo(expectedSearchResult)
    }

    @Test
    fun `Pattern matching nothing in text should return nothing`() {
        val linguisticSearch = LinguisticSearch()

        val textContent = TextContent.empty()
            .addWord("Cabbages", PosTag.NOUN)

        val searchPattern = SearchPattern.empty()
            .addPattern(PosTag.CCONJ)

        val searchResult =
            linguisticSearch.search(searchPattern, textContent)

        assertThat(searchResult.isEmpty()).isTrue
    }
}