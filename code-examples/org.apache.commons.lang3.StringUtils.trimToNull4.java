StringUtils.trimToNull(null) = null
StringUtils.trimToNull("") = null
StringUtils.trimToNull(" ") = null
StringUtils.trimToNull(" \b \t \n \f \r ") = null
StringUtils.trimToNull(" \n\tss \b") = "ss"
StringUtils.trimToNull(" d d dd ") = "d d dd"
StringUtils.trimToNull("dd ") = "dd"
StringUtils.trimToNull(" dd ") = "dd"