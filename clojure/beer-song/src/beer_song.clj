(ns beer-song)

(defn bottles->str
  "Returns the correct bottle plurality/phrase for the number argument passed in"
  [num]
  (if (zero? num)
    "no more bottles"
    (str num (case num
               1 " bottle"
               " bottles"))))

(defn second-line-first-part
  [num]
  (let [bottles (bottles->str num)]
    (if (zero? num)
      "Go to the store and buy some more, "
      (format "Take %s down and pass it around, "
              (if (= 1 num) "it" "one")))))

(defn second-line-last-part
  [num]
  (format "%s of beer on the wall.\n"
          (bottles->str (if (> 0 num) 99 num))))

(defn second-line
  [num]
  (str
   (second-line-first-part num)
   (second-line-last-part (dec num))))

(defn verse
  "Returns the nth verse of the song."
  [num]
  (let [bottles (bottles->str num)]
    (str
     (clojure.string/capitalize bottles) " of beer on the wall, " bottles " of beer.\n" (second-line num))))

(defn sing
  "Given a start and an optional end, returns all verses in this interval. If
  end is not given, the whole song from start is sung."
  ([start] (sing start 0))
  ([start end]
   (loop
       [curr start
        result []]
     (if (= curr end)
       (apply str (conj result (verse curr)))
       (recur
        (dec curr) (conj result (verse curr) "\n"))))))
