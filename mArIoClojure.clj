;;higher order function:
(defn task
  ;;takes function (+,-,*,/) as parameter f:
  [f a b]
  (println "What is the result of" a f b "?")
  ;;user input:
  (let [userResult (read-line)]
    ;;compare userResult with solution:
    (println "Your answer is" (= (str((load-string f) a b)) userResult))
    ;;print solution:
    (println "Solution:" (str((load-string f) a b)))
    ;;returns closure:
    (fn [](load-string f) a b))
)

(def operations ["+" "-" "*" "/"])

(do
  (task (rand-nth operations) (rand-int 100) (rand-int 100))
)