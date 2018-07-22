(ns collatz-conjecture)


(defn calculate-next-val
  [num]
  (if (even? num) (/ num 2) (+ 1 (* 3 num))))

(defn collatz
  [num]
  (cond
    (neg? num) (throw (IllegalArgumentException. "negative value is an error"))
    (zero? num) (throw (IllegalArgumentException. "zero is an error"))
    :else (loop
              [count 0
               n num]
            (if (>= 1 n)
              count
              (recur (inc count) (calculate-next-val n))))))
