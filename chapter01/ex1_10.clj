(defn A
  [x y]
  (cond
    (= y 0) 0
    (= x 0) (* 2 y)
    (= y 1) 2
    :else (A (- x 1)
             (A x (- y 1)))))

(println (str "(A 1 10): "
              (A 1 10)))
;; (A 0 (A 1 9))
;; (A 0 (A 0 (A 1 8)))
;; (A 0 (A 0 (A 0 (A 1 7))))
;; (A 0 (A 0 (A 0 (A 0 (A 1 6)))))
;; (A 0 (A 0 (A 0 (A 0 (A 0 (A 1 5))))))
;; (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 1 4)))))))
;; (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 1 3))))))))
;; (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 1 2)))))))))
;; (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 1 1))))))))))
;; (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 2))))))))
;; (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 4))))))
;; (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 8))))
;; (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 16))))
;; (A 0 (A 0 (A 0 (A 0 (A 0 32)))))
;; (A 0 (A 0 (A 0 (A 0 64))))
;; (A 0 (A 0 (A 0 128)))
;; (A 0 (A 0 256))
;; (A 0 512)
;; => 1024

(println (str "(A 2 4): "
              (A 2 4)))
;; (A 1 (A 2 3))
;; (A 1 (A 1 (A 2 2)))
;; (A 1 (A 1 (A 1 (A 2 1))))
;; (A 1 (A 1 (A 1 2)))
;; (A 1 (A 1 (A 0 (A 1 1)))
;; (A 1 (A 1 (A 0 2)))
;; (A 1 (A 1 4))
;; As we could see in the exercise above (A 1 n) = 2 ^ n
;; because it will recursivelly iterate until (A 1 1), which is equal to 2,
;; and will multiply it by 2, (n - 1) times.
;; So, (A 1 (A 1 4)) => (A 1 16) => 2 ^ 16 => 65536

(println (str "(A 3 3): "
              (A 3 3)))
;; (A 2 (A 3 2))
;; (A 2 (A 2 (A 2 1))
;; (A 2 (A 2 2))
;; (A 2 (A 1 (A 2 1)))
;; (A 2 (A 1 2))
;; Using the rule above ...
;; (A 2 4)
;; => 65536


(defn f [n] (A 0 n))
;; => (defn f [n] (* 2 n))

(defn g [n] (A 1 n))
;; => (defn g [n] (Math/pow 2 n))

(defn h [n] (A 2 n))
;; (A 2 1) => 2
;; (A 2 2) => (A 1 (A 2 1)) => (A 1 2) => 4
;; (A 2 3) => (A 1 (A 2 2)) => (A 1 4) => 16
;; (A 2 4) => (A 1 (A 2 3)) => (A 1 16) => 65536
;; => 2 ^ (2 ^ (2 ^ ...)) -- n times
