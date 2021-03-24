final Appendable out = ...;
          final CSVPrinter printer = CSVFormat.DEFAULT.withHeader("H1", "H2").print(out)