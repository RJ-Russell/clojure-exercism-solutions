(ns robot-name)

(defrecord Robot [name])

(defn- rand-alpha [] (rand-nth (map char (range 65 91))))

(defn- new-name
  []
  (format "%s%s%03d"
          (rand-alpha) (rand-alpha) (rand-int 1000)))

(defn robot
  []
  (Robot. (atom (new-name))))

(defn robot-name
  [robot] 
  @(:name robot))

(defn reset-name
  [robot]
  (reset! (:name robot) (new-name)))
