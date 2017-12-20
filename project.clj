(defproject riemann "0.2.15-SNAPSHOT"
  :description
"A network event stream processor. Intended for analytics, metrics, and alerting; and to glue various monitoring systems together."
  :url "https://github.com/riemann/riemann"
;  :warn-on-reflection true
;  :jvm-opts ["-server" "-d64" "-Xms1024m" "-Xmx1024m" "-XX:+CMSParallelRemarkEnabled" "-XX:+AggressiveOpts" "-verbose:gc" "-XX:+PrintGCDetails"]
  :jvm-opts ["-server" "-Xms1024m" "-Xmx1024m" "-XX:+CMSParallelRemarkEnabled" "-XX:+AggressiveOpts" "-XX:+CMSClassUnloadingEnabled" "-XX:+IgnoreUnrecognizedVMOptions" "--add-modules=java.xml.bind"]
  :maintainer {:email "aphyr@aphyr.com"}
  :dependencies [
    [org.clojure/algo.generic "0.1.2"]
    [org.clojure/clojure "1.9.0"]
    [org.clojure/math.numeric-tower "0.0.4"]
    [org.clojure/tools.logging "0.4.0"]
    [org.clojure/tools.nrepl "0.2.13"]
    [org.clojure/core.cache "0.6.5"]
    [org.clojure/data.priority-map "0.0.7"]
    [org.clojure/java.classpath "0.2.3"]

    [org.slf4j/log4j-over-slf4j "1.7.25"]
    [ch.qos.logback/logback-classic "1.2.3"]
    [com.github.juise/logstash-logback-layout "1.0"]
    [net.logstash.logback/logstash-logback-encoder "4.11"]
    [org.influxdb/influxdb-java "2.8"]
    [com.cemerick/pomegranate "1.0.0"
     :exclusions [org.codehaus.plexus/plexus-utils]]
    ; for pomegranate
    [org.codehaus.plexus/plexus-utils "3.0"]
    [http-kit "2.2.0"]
    [clj-http "3.7.0"]
    [cheshire "5.8.0"]
    [clj-librato "0.0.5"]
    [clj-time "0.14.2"]
    [clj-wallhack "1.0.1"]
    [com.boundary/high-scale-lib "1.0.6"]
    [com.draines/postal "2.0.2"]
    [com.amazonaws/aws-java-sdk "1.11.116" :exclusions [joda-time]]
    [interval-metrics "1.0.0"]
    [clj-antlr "0.2.4"]
    [io.netty/netty-all "4.1.19.Final"]
    [riemann-clojure-client "0.4.5"]
    [less-awful-ssl "1.0.2"]
    [slingshot "0.12.2"]
    [cljr-nsca "0.0.3"]
    [amazonica "0.3.95" :exclusions [joda-time]]
    [spootnik/kinsky "0.1.20"]
    [pjstadig/humane-test-output "0.8.3"]]
  :plugins [[lein-codox "0.10.2"]
            [lein-difftest "2.0.0"]
            [lein-rpm "0.0.6"
             :exclusions [org.apache.maven/maven-plugin-api
                          org.codehaus.plexus/plexus-container-default
                          org.codehaus.plexus/plexus-utils
                          org.clojure/clojure
                          classworlds]]
            ; for lein-rpm
            [org.apache.maven/maven-plugin-api "2.0"]
            [org.codehaus.plexus/plexus-container-default
             "1.0-alpha-9-stable-1"]
            [org.codehaus.plexus/plexus-utils "1.5.15"]
            [classworlds "1.1"]]
  :profiles {:dev {:jvm-opts ["-XX:-OmitStackTraceInFastThrow"]
;                              "-Dcom.sun.management.jmxremote"
;                              "-XX:+UnlockCommercialFeatures"
;                              "-XX:+FlightRecorder"]
                   :dependencies [[criterium "0.4.4"]]}}
  :test-selectors {:default (fn [x] (not (or (:integration x)
                                             (:time x)
                                             (:bench x))))
                   :integration :integration
                   :email :email
                   :sns :sns
                   :graphite :graphite
                   :influxdb :influxdb
                   :kairosdb :kairosdb
                   :librato :librato
                   :hipchat :hipchat
                   :nagios :nagios
                   :opentsdb :opentsdb
                   :time :time
                   :bench :bench
                   :focus :focus
                   :slack :slack
                   :druid :druid
                   :cloudwatch :cloudwatch
                   :datadog :datadog
                   :stackdriver :stackdriver
                   :xymon :xymon
                   :shinken :shinken
                   :telegram :telegram
                   :blueflood :blueflood
                   :opsgenie :opsgenie
                   :boundary :boundary
                   :prometheus :prometheus
                   :elasticsearch :elasticsearch
                   :netuitive :netuitive
                   :kafka :kafka
                   :pushover :pushover
                   :msteams :msteams
                   :all (fn [_] true)}
;;  :javac-options     ["-target" "1.6" "-source" "1.6"]
  :java-source-paths ["src/riemann/"]
  :java-source-path "src/riemann/"
;  :aot [riemann.bin]
  :codox {:output-path "site/api"
          :source-uri "https://github.com/riemann/riemann/blob/{version}/{filepath}#L{line}"
          :metadata {:doc/format :markdown}}
)
