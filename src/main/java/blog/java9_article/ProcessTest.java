package blog.java9_article;

import java.time.Duration;
import java.time.Instant;
import java.util.Optional;
import java.util.stream.Stream;

public class ProcessTest {

    public static void main(String[] args) {

        ProcessHandle self = ProcessHandle.current();
        ProcessHandle.Info processorInfo = self.info();

        Long processId = self.pid();
        Optional<Instant> startTime = processorInfo.startInstant();
        Optional<Duration> cpuDuration = processorInfo.totalCpuDuration();
        Optional<String[]> arguments = processorInfo.arguments();
        Optional<String> commandLine =  processorInfo.commandLine();
        Optional<String> command = processorInfo.command();
        Optional<String> user = processorInfo.user();

        Stream<ProcessHandle> children = self.children();

        children.forEach(child -> child.destroy());

    }
}
