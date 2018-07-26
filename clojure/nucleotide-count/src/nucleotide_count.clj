(ns nucleotide-count)

(def nucleotides {\A 0 \C 0 \G 0 \T 0})

(defn count [nucleotide strand]
  (get (frequencies strand) nucleotide))

(defn nucleotide-counts
  [strand]
  ()
