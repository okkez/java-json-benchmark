package net.okkez;

import net.okkez.sample.*;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

@BenchmarkMode({Mode.Throughput,Mode.AverageTime,Mode.SingleShotTime})
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Benchmark)
public class BenchmarkJson {

    @Param({"{\"push_enabled\":true}", "{}", "{\"product_name\": \"testproduct\", \"age\": 100, \"category\": \"acc\"}"})
    public String rawProperties;

    @Benchmark
    public HashMap<String, String> jackson() throws IOException {
        SampleJackson t = new SampleJackson();
        return t.buildProperties(rawProperties);
    }

    @Benchmark
    public HashMap<String, String> orgJson() {
        SampleJson t = new SampleJson();
        return t.buildProperties(rawProperties);
    }

    @Benchmark
    public HashMap<String, String> jsonp() {
        SampleJsonP t = new SampleJsonP();
        return t.buildProperties(rawProperties);
    }

    @Benchmark
    public HashMap<String, String> gson() {
        SampleGson t = new SampleGson();
        return t.buildProperties(rawProperties);
    }

    @Benchmark
    public HashMap<String, String> moshi() throws IOException {
        SampleMoshi t = new SampleMoshi();
        return t.buildProperties(rawProperties);
    }

    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
                .include(BenchmarkJson.class.getSimpleName())
                .forks(1)
                .build();
        new Runner(options).run();
    }
}
