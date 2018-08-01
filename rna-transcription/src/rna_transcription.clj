(ns rna-transcription)

(def rna-map {\G "C" \C "G" \T "A" \A "U"})

(defn to-rna [dna]
  {:pre [(every? #(contains? rna-map %) dna)]}
  (clojure.string/join (map #(get rna-map %) dna)))
