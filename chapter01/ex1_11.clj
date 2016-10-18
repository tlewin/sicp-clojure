(defn print-results
  [f times]
  (loop [n times]
    (println "f(" n "): " (f n))
    (if (> n 0)
      (recur (- n 1)))))

(defn f-recursive
  [n]
  (cond (< n 3) n
        :else (+ (f-recursive (- n 1))
                 (* 2 (f-recursive (- n 2)))
                 (* 3 (f-recursive (- n 3))))))

(defn  f-iterative-step
  [a b c count]
  (if (= count 0)
      a
      (recur b c (+ (* 3 a)
                    (* 2 b)
                    c)
             (- count 1))))

(defn f-iterative
  [n]
  (f-iterative-step 0 1 2 n))

(println "Results for recursive f:")
(time (print-results f-recursive 10))

(println "Results for iterative f:")
(time (print-results f-iterative 10))
