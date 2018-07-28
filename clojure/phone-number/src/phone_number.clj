(ns phone-number)

;; Length less than 10, return all zeros
;; Lenght 11, but first character is not a 1, return all zeros
;; Length 11, first character is a one, return the string minus the first character
;; Otherwise return the string

(defn invalid-number?
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
  )

(defn pretty-print [num-string] ;; <- arglist goes here
  ;; your code goes here
  )
