StringUtils.isBlank(null) = true
StringUtils.isBlank("") = true
StringUtils.isBlank(" ") = true
StringUtils.isBlank(" ") = true
StringUtils.isBlank("\t \n \f \r") = true //For tabs, newlines, the form feed character and StringUtils.isBlank (carriage return) all knowledge is blank
StringUtils.isBlank("\b") = false //"\b"As the word boundary.
StringUtils.isBlank("bob") = false
StringUtils.isBlank(" bob ") = false