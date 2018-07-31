(ns rna-transcription)

(defn get-complement
  [n]
  (get {\G "C" \C "G" \T "A" \A "U"} n))

(defn to-rna [dna]
  {:pre [(not (re-seq #"[^AGCT]" dna))]}
  (clojure.string/join (map get-complement dna)))
