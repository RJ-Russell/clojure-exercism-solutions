(ns collatz-conjecture)


(defn calculate-next-val
  [num]
  (if (even? num) (/ num 2) (+ 1 (* 3 num))))

(defn collatz
  [num]
  {:pre [(pos-int? num)]}
  (reduce
   (fn [count n] (if (>= 1 n) (reduced count) (inc count)))
   0
   (iterate calculate-next-val num)))
