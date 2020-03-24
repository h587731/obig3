public class Oppgave2 {
    public static void main(String[] args) {


        /**
         *
         * Metoden nyMidten er O(n). Hvorfor?
         * metoden itererer gjennom halvparten av n elementer
         * 0.5n
         *
         * vi fjerner konstanter når vi finner big O
         *  dermed har metoden O=(n)
         *
         *  om midt må oppdaters når vi legger til eller fjerner.
         *
         *  Om vi legger til i en del  må midt flyttes en posisjon mot same del
         *  om vi fjerner fra en del må midt flyttes en posisjon mot motsatt del.
         *
         *  I tilleg trenger vi kun å oppdatere når nytt antall er oddetall
         *   og vi trenger ikke å oppdatere om vi endrer til i annene hver del med samme type operasjon
         *   Altså: N er oddetal. Legg til over mid. n er partall. legg til under min.
         *   n er oddetall men trenger ikke å oppdateres.
         *
         *   eller ved fjerning og legg til på samme side i annenhver sekvens.
         *
         *
         *  D
         *  i)
         *
         *  gjennomsnitt av linear søk når vi vet det finnest og posijonen er vilkårlig
         *  er 1/n. hver posisjon er like sannsynlig.
         *  1*1/n+2*1/n+3*1/n+.....n*1/n    / n
         *  (1/n+2/n+3/n+....n*1/n)           / n
         *  (1+2+3+4+5....(n-1)+n)/n
         *    sum = 1+2+3+4+5....(n-1)+n
         *    2sum= (n+1)n
         *          sum= n(n+1)/2               / n
         *      n(n+1)/2 /n
         *          (n+1)/2
         *  gjennomsnitt n+1/2
         *
         *  ; worst n antall
         *
         *
         *  ii) med midt en veis
         *
         *      avrage er halvparten av avrage i i. (linear uten mid
         *      mens worst 0.5n
         *
         *   iii)
         *   avrage er halvparten av avrage i  ii (linear med mid
         *          *      mens worst 0.25n
         *
         */




    }
}
