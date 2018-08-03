(ns run-length-encoding)

(defn- element->str
  [coll]
  (let [cnt (count coll)
        first (first coll)]
    (if (= cnt 1) (str first) (str cnt first))))

(defn run-length-encode
  "encodes a string with run-length-encoding"
  [plain-text]
  (let [text (partition-by identity plain-text)
        encoded (map element->str text)]
    (if (empty? encoded) "" (clojure.string/join encoded))))

(defn- str->num
  [s]
  (if (nil? s) 1 (read-string (clojure.string/join s))))

(defn- explode-elements
  [coll]
  (map #(repeat (str->num (butlast %)) (last %)) coll))

(defn run-length-decode
  "decodes a run-length-encoded string"
  [cipher-text]
  (let [elements (re-seq #"\d*\D" cipher-text)]
    (apply str
           (map #(clojure.string/join %) (explode-elements elements)))))
