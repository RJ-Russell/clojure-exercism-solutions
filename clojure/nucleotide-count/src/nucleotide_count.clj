(ns nucleotide-count)

(defn count [nucleotide strand]
  {:post [((complement nil?) %)]}
  (if (clojure.string/blank? strand) 0 (get (frequencies strand) nucleotide)))


(defn nucleotide-counts
[strand]
(merge {\A 0 \T 0 \C 0 \G 0} (frequencies strand)))
