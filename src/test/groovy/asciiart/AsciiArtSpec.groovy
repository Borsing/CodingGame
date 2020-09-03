package asciiart

import spock.lang.Specification
import spock.lang.Unroll

import java.nio.file.Files
import java.nio.file.Paths
import java.util.function.Function
import java.util.stream.Collectors
import java.util.stream.IntStream

class AsciiArtSpec extends Specification {

    @Unroll
    void "Test AsciiArt #testCase"() {
        given:
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ?"
        def asciiAlphabetMapper = readAlphabet(testCase, alphabet)
        def expectedAsciiWord = Files.lines(Paths.get("src/test/resources/asciiart/test_case_expected${testCase}.txt")).collect(Collectors.joining("\n"))

        when:
        def asciiWord = writeWord(asciiAlphabetMapper, wordToWrite)

        then:
        asciiWord == expectedAsciiWord

        where:
        testCase | wordToWrite
        1        | "E"
        2        | "MANHATTAN"
        3        | "ManhAtTan"
        4        | "M@NH@TT@N"
        5        | "MANHATTAN"
    }

    static Map<Integer, List<String>> readAlphabet(int testCase, String alphabet) {
        File f = new File("src/test/resources/asciiart/test_case${testCase}.txt")
        def scanner = new Scanner(f)
        def lengthLetter = scanner.nextInt()

        final List<String> alphabetAsciiLines = f.readLines().drop(2)

        return alphabet.chars()
                .boxed()
                .collect(Collectors.toMap(Function.identity(),
                        {
                            int index = alphabet.indexOf(it as int)
                            alphabetAsciiLines.stream().map({ it.substring(index * lengthLetter, index * lengthLetter + lengthLetter) }).collect(Collectors.toUnmodifiableList())
                        }
                ))
    }

    static String writeWord(Map<Integer, List<String>> asciiAlphabetMapper, String wordToWrite) {
        List<List<String>> wordWithAlphabetIndexed =
                wordToWrite.toUpperCase().chars()
                        .boxed()
                        .map({ Character.isAlphabetic(it) ? it : (('?' as char) as int)})
                        .map({ asciiAlphabetMapper.get(it) })
                        .collect(Collectors.toList())

        int maxHeight = wordWithAlphabetIndexed.stream().mapToInt({ it.size() }).max().getAsInt()
        
        return IntStream.range(0, maxHeight)
                .mapToObj({ height ->
                    wordWithAlphabetIndexed.stream()
                            .map({ height < it.size() ?  it.get(height) : "" })
                            .collect(Collectors.joining(""))
                })
                .collect( Collectors.joining("\n"))
    }
}
