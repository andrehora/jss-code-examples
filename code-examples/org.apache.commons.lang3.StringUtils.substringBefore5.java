StringUtils.substringBefore(null, *)            = null
StringUtils.substringBefore("", *)              = ""
StringUtils.substringBefore("asdfg", null))     = "asdfg"
StringUtils.substringBefore("asdfg", "a"))      = ""
StringUtils.substringBefore("asdfg", "sd"))     = "a"
StringUtils.substringBefore("asdfsag", "sa"))   = "asdf"
StringUtils.substringBefore("asdfg", "h"))      = "asdfg"
StringUtils.substringBefore("asdfg", ""))       = ""
StringUtils.substringBefore("asdfg", "dfgh"))   = "asdfg"
StringUtils.substringBefore("asdfg", "dfg"))    = "as"
StringUtils.substringBefore("abbbabbba", "bb")) = "a"