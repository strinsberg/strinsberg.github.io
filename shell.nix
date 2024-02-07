{ pkgs ? import <nixpkgs> {} }:

pkgs.mkShell {
  buildInputs = with pkgs.buildPackages; [
    babashka # for tasks and scripts
    pandoc # for converting markdown to html
    httplz # serve the website locally for testing
  ];
}

