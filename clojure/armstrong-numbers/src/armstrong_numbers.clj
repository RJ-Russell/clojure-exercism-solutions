(ns armstrong-numbers)

(defn pow
  [num p]
  (int (Math/pow num p)))

(defn explode
  [num]
  (map #(Character/getNumericValue %) (str num)))

(defn armstrong? [num] ;; <- arglist goes here
  (let [nums (explode num)
        p (count nums)]
    (= num (reduce + (map #(pow % p) nums)))))
  
