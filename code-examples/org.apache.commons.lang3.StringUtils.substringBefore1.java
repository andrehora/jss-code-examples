StringUtils.substringBefore(null, *)      = null
StringUtils.substringBefore("", *)        = ""
StringUtils.substringBefore("abc", "a")   = ""
StringUtils.substringBefore("abcba", "b") = "a"
StringUtils.substringBefore("abc", "c")   = "ab"
StringUtils.substringBefore("abc", "d")   = "abc"
StringUtils.substringBefore("abc", "")    = ""
StringUtils.substringBefore("abc", null)  = "abc"