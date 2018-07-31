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
  (let [caps? (all-caps? s)
        question? (is-question? s)]
    (cond
      (clojure.string/blank? s) "Fine. Be that way!"
      (and caps? question?) "Calm down, I know what I'm doing!"
      question? "Sure."
      caps? "Whoa, chill out!"
      :else "Whatever.")))
