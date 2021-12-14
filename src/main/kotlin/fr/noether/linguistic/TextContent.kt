package fr.noether.linguistic

data class TextContent(
    val word: String,
    val posTag: PosTag
    ) {

    fun addWord(word: String, posTag: PosTag): TextContent {
        return TextContent(word, posTag)
    }

    fun contains(word: String): Boolean {
        return this.word == word;
    }

    fun match(searchPattern: SearchPattern): Boolean {
        return searchPattern.posTag == this.posTag
    }

    companion object{
        fun empty() = TextContent("", PosTag.NONE)
    }
}
