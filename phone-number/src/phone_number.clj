(ns phone-number)

(defn- invalid-number?
  [s]
  (let [num-size (count s)]
    (or
     (< num-size 10)
     (> num-size 11)
     (and
      (= num-size 11) (not= (first s) "1")))))

(defn number [num-string]
  (let [n-coll (re-seq #"\d" num-string)]
    (if (invalid-number? n-coll)
      "0000000000"
      (apply str
             (if (= 11 (count n-coll)) (rest n-coll) n-coll)))))

(defn area-code [num-string] 
  (subs (number num-string) 0 3))

(defn pretty-print
  [num-string]
  (let [ac (area-code num-string)
        num (subs (number num-string) 3)]
    (str "(" ac ") " (subs num 0 3) "-" (subs num 3))))
