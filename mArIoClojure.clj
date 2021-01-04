;;higher order function:
(defn task
  ;;takes function (+,-,*,/) as parameter f:
  [f a b]
  (println "What is the result of" a f b "?")
  ;;user input:
  (let [result (read-line)]
    ;;result:
    (println (= (str((load-string f) a b)) result))
    ;;returns closure:
    (fn [](load-string f) a b))
)

(def operations ["+" "-" "*" "/"])

(do
  (println "solution:" (task (rand-nth operations) (rand-int 100) (rand-int 100)))
)