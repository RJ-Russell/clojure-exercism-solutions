(ns grade-school)

(defn grade
  [school grade]
  (get school grade []))

(defn add
  [school name grade]
  (assoc school grade
         (if (school grade)
           (conj (get school grade) name)
           (conj [] name))))

(defn sorted [school]
  (into (sorted-map)
        (into {} (for [[k v] school] [k (sort v)]))))

