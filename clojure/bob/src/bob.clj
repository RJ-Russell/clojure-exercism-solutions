(ns bob)

(defn is-question?
  [s]
  (= \? (last s)))

(defn all-caps?
  [s]
  (and
   (re-find #"[A-Za-z]" s)
   (= (clojure.string/upper-case s) s)))

(defn response-for
  [s]
  (cond
    (clojure.string/blank? s) "Fine. Be that way!"
    (and (all-caps? s) (is-question? s)) "Calm down, I know what I'm doing!"
    (is-question? s) "Sure."
    (all-caps? s) "Whoa, chill out!"
    :else "Whatever."))
